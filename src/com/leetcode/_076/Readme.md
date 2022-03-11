https://labuladong.gitee.io/algo/2/22/60/
滑动窗口防滑记

```text
链表子串数组题，用双指针别犹豫。
双指针家三兄弟，各个都是万人迷。

快慢指针最神奇，链表操作无压力。
归并排序找中点，链表成环搞判定。

左右指针最常见，左右两端相向行。
反转数组要靠它，二分搜索是弟弟。

滑动窗口老猛男，子串问题全靠它。
左右指针滑窗口，一前一后齐头进。
自称十年老司机，怎料农村道路划。
。。。
```

```cpp
/* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    unordered_map<char, int> need, window;
    for (char c : t) need[c]++;
    
    int left = 0, right = 0;
    int valid = 0;
    while (right < s.size()) {
        // c是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...
        
        /*** debug 输出的位置 ***/
        printf("window: [%d, %d)\n", left, right);
        /********************/
        
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```
