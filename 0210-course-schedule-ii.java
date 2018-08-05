class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) result[i] = i;    
            return result;
        }
        
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] depends = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (!graph.containsKey(prerequisite[1])) graph.put(prerequisite[1], new ArrayList<Integer>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
            
            depends[prerequisite[0]]++;
        }
        
        Queue<Integer> courses = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (depends[i] == 0) {
                courses.add(i);
            }
        }
        
        if (courses.size() == 0) return new int[0];
        
        int j = 0;
        while (j < numCourses) {
            if (courses.size() == 0) return new int[0];
            int courseId = courses.remove();
            result[j++] = courseId;
            if (graph.containsKey(courseId)) {
                for (Integer i : graph.get(courseId)) {
                    if (--depends[i] == 0) courses.add(i);
                }
            }
        }
        
        return result;
    }
}
