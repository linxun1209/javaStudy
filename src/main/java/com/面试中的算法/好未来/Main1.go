//package main
///**
// * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
// *
// *
// * @param nums int整型一维数组
// * @return int整型
// */
//func maxAscendingSum( nums []int ) int {
//	// write code here
//	if(len(nums)==0){
//		return 0;
//	}
//	maxSum:=0;
//	currentSum:=0;
//	for i:=1;i<len(nums);i++{
//		if(i==0||nums[i]<nums[i-1]){
//			currentSum+=nums[i];
//		}else {
//			if currentSum>maxSum {
//				maxSum = currentSum;
//			}
//			currentSum=nums[i];
//		}
//	}
//	if currentSum>maxSum {
//		maxSum = currentSum;
//	}
//	return maxSum;
//}