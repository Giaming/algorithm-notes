package main

import "fmt"

/**
冒泡排序是从左到右依次比较相邻的两个元素，如果前一个元素比较大，就把前一个元素和后一个交换位置，
遍历数组之后保证最后一个元素相对于前面的永远是最大的。然后让最后一个保持不变，重新遍历前n-1个元素，保证第n-1个元素在前n-1个元素里面是最大的。
依此规律直到第2个元素是前2个元素里面最大的，排序就结束了。
 */
func bubbleSort(nums []int) []int {
	n := len(nums)
	for i := 0; i < n - 1; i++ {
		exchange := false
		for j := 0; j < n-i-1; j++ {
			if nums[j] > nums[j+1] { //两两比较，前面比后面大
				nums[j], nums[j+1] = nums[j+1], nums[j] //交换
				exchange = true
			}
		}
		if !exchange {
			return nums
		}
	}
	return nums
}

func main() {
	nums := []int{4,2,3,2,1}
	res := bubbleSort(nums)
	fmt.Println(res)
}
