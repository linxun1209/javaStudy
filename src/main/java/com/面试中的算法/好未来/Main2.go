///*
//* type TreeNode struct {
//*   Val int
//*   Left *TreeNode
//*   Right *TreeNode
//* }
//*/
//
///**
//* 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//*
//*
//* @param root TreeNode类
//* @param target int整型
//* @return int整型
//*/
//func searchBST( root *TreeNode ,  target int ) int {
//   // write code here
//
//   if root==nil{
//       return -1;
//   }
//   if(root.val==target){
//       return root.val;
//   }
//   if(root.val>target){
//       return searchBST(root.Left,target);
//   }else{
//       return searchBST(root.Right,target);
//   }
//}