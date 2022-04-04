[77. 组合](https://leetcode-cn.com/problems/combinations/)
```java
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return result;
        }
        backTracing(n,k,1);  // DFS
        return result;
    }

    private void backTracing(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            backTracing(n,k,i+1);
            path.removeLast();
        }
    }
}
```

[216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii/)
```java
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(n, k, 1);
        return result;
    }

    private void backTracing(int target, int k, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0 && path.size() == k){
            result.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.push(i);
            backTracing(target - i, k, i+1);
            path.pop();
        }
    }
}
```

[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
```java
class Solution {
    List<String> result = new ArrayList<>();
    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        // 初始化所有数字
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 迭代处理
        backTracing(digits, numString, 0);
        return result;
    }

    private void backTracing(String digits, String[] numString, int num) {
        // 遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            result.add(temp.toString());
            return;
        }
        // str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracing(digits, numString, num+1);
            // 剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
```

[39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)
```java
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return result;
    }

    private void backTracking(int[] candidates, int target,int sum, int startIdx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // sum + candidates[i] <= target  属于剪枝操作
        for (int i = startIdx; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.push(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.pop();
        }
    }
}
```

[40.组合总和II](https://leetcode-cn.com/problems/combination-sum-ii/)

```java
static class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, target, 0, 0);
        return result;
    }

    private void backTracing(int[] candidates, int target, int sum, int startIdx) {
        if (target < sum) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < candidates.length && sum + candidates[i] <= target; i++) {
            // used[i-1] == true, 说明同一树枝candidates[i-1]使用过
            // used[i-1] == false, 说明同一树层candidates[i-1]使用过
//            if (i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) {
//                continue;
//            }
            if (i > startIdx && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.push(candidates[i]);
            sum += candidates[i];
//            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i])+" sum = " + sum);
            backTracing(candidates, target, sum, i+1);
            sum -= candidates[i];
            path.pop();
//            System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i])+" sum = " + sum);
        }
    }
}
```

[131.分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning/)
```java
class Solution {
    List<List<String>> res = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int startIdx) {
        // 退出条件,如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
        if (startIdx >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < s.length(); i++) {
            // 如果是回文串，则记录
            if (isPalindrome(s, startIdx, i)) {
                String str = s.substring(startIdx, i + 1);
                path.addLast(str);
            }else {
                continue;
            }
            dfs(s, i + 1);
            path.removeLast();
        }
    }

    // 判断回文串
    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
```

[93. 复原 IP 地址](https://leetcode-cn.com/problems/restore-ip-addresses/)
```java
//方法二：比上面的方法时间复杂度低，更好地剪枝，优化时间复杂度
class Solution2 {
    List<String> result = new ArrayList<String>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddressesHandler(s, 0, 0);
        return result;
    }

    // number表示stringbuilder中ip段的数量
    public void restoreIpAddressesHandler(String s, int start, int number) {
        // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
        if (start == s.length() && number == 4) {
            result.add(stringBuilder.toString());
            return;
        }
        // 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
        if (start == s.length() || number == 4) {
            return;
        }
        // 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
        for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
                && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
            // 如果ip段的长度大于1，并且第一位为0的话，continue
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                continue;
            }
            stringBuilder.append(s.substring(start, i + 1));
            // 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
            if (number < 3) {
                stringBuilder.append(".");
            }
            number++;
            restoreIpAddressesHandler(s, i + 1, number);
            number--;
            // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
            stringBuilder.delete(start + number, i + number + 2);
        }
    }
}
```
[78. 子集](https://leetcode-cn.com/problems/subsets/)
```java
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        subsetHelper(nums, 0);
        return res;
    }

    private void subsetHelper(int[] nums, int startIndex) {
        // 「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」
        res.add(new ArrayList<>(path));
        // 终止条件可加可不加
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.addLast(nums[i]);
            subsetHelper(nums, i + 1);
            path.removeLast();
        }
    }
}
```

[90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)
```java
// 不使用used数组
class Solution2 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithHelper(nums, 0);
        return result;
    }

    private void subsetsWithHelper(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 跳过当前树层使用过的相同的元素
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithHelper(nums, i+1);
            path.removeLast();
        }
    }
}
```

[491. 递增子序列](https://leetcode-cn.com/problems/increasing-subsequences/)
```java
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracing(nums, 0);
        return res;
    }

    private void backtracing(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];  // -100 <= nums[i] <= 100标记重复值
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()  // 排除掉不是递增的值
                || (used[nums[i]+100] == 1)) {  // 排除掉重复值
                continue;
            }
            used[nums[i]+100] = 1;
            path.add(nums[i]);
            backtracing(nums, i+1);
            path.removeLast();
        }
    }
}
```

[46. 全排列](https://leetcode-cn.com/problems/permutations/)
```java
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        used = new boolean[nums.length];
        backtracing(nums);
        return res;
    }

    private void backtracing(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtracing(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
```








## [22 括号生成](https://leetcode-cn.com/problems/generate-parentheses/submissions/)

使用回溯算法，进行dfs

```java
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
}
```

**题解**：
[回溯算法（深度优先遍历）+ 广度优先遍历（Java)](https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/)

