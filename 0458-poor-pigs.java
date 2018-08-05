class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        Double d = Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
        return d.intValue();
    }
}
