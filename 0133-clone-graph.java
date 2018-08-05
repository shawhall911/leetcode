/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hs = 
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return clone(node, hs);
}
    
    UndirectedGraphNode clone(UndirectedGraphNode node, 
                              HashMap<UndirectedGraphNode, UndirectedGraphNode> hs){
        
        int v = node.label;
        UndirectedGraphNode newN = new UndirectedGraphNode(v);
        hs.put(node, newN);
        
        for(UndirectedGraphNode nei : node.neighbors){
            if(nei == node) {
                //self-pointing
                newN.neighbors.add(newN);
                continue;
            }
            
            UndirectedGraphNode newNei;           
                       
            if(!hs.containsKey(nei)) { 
                newNei = clone(nei,hs);    
            }
            else{ //already cloned a node
                newNei = hs.get(nei);
            }
            //draw the edge
            newN.neighbors.add(newNei);
            
        }
        return newN;
    }
}
