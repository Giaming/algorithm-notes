package main

/**
快速排序的主要思想是通过划分将待排序的序列分成前后两部分，其中前一部分的数据都比后一部分的数据要小，然后再递归调用函数对两部分的序列分别进行快速排序，以此使整个序列达到有序。
 */
func quickSort(q []int, l, r int) {
	if l >= r { // 终止条件
		return
	}
	x := q[(l+r)>>1] // 确定分界点
	i, j := l-1, r+1 // 两个指针，因为do while要先自增/自减
	for i < j {      // 每次迭代
		for { // do while 语法
			i++ // 交换后指针要移动，避免没必要的交换
			if q[i] >= x {
				break
			}
		}
		for {
			j--
			if q[j] <= x {
				break
			}
		}
		if i < j { // swap 两个元素
			q[i], q[j] = q[j], q[i]
		}
	}
	quickSort(q, l, j) // 递归处理左右两段
	quickSort(q, j+1, r)
}

