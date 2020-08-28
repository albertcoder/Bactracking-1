//APPROACH: Recursion
//time complexity O(2^n)
//space complexity O(n2^n)

class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        targ = target;
        helper(candidates, 0, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int sum, int index, List<Integer> temp){
        //base
        if(sum == targ){
            result.add(temp);
            return;
        }
        if(sum > targ || index == candidates.length) return;
        //logic
        //if I don't choose
        helper(candidates, sum, index + 1, new ArrayList<>(temp));

        //if I choose
        temp.add(candidates[index]);
        helper(candidates, sum + candidates[index], index, new ArrayList<>(temp));

    }
}

//APPROACH: Backtracking (as did in class)
//time complexity(2^n)
//space complexity(n)

class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        targ = target;
        backtrack(candidates, 0, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(int[] candidates, int sum, List<Integer> temp, int index){
        //base
        if(sum == targ){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > targ) return;
        //logic
        for(int i = index; i < candidates.length; i++){
            temp.add(candidates[i]);
            backtrack(candidates, sum + candidates[i], temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}


//APPROACH: Backtracking (my version)
//time complexity O(2^n)
//space complexity O(n)
class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        targ = target;
        backtrack(candidates, 0, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int sum, int index, List<Integer> temp){
        //base
        if(sum == targ){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > targ || index == candidates.length) return;
        //logic
        //if I don't choose
        backtrack(candidates, sum, index + 1, temp);

        //if I choose
        temp.add(candidates[index]);
        backtrack(candidates, sum + candidates[index], index, temp);
        temp.remove(temp.size() - 1);

    }
}
