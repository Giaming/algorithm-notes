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

