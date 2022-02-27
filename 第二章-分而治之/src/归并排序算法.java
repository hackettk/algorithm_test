
/**
 * @author HK
 * @version 1.0
 * @title: 归并排序算法
 * @description: TODO
 * @date 2022/2/27 13:13
 */
public class 归并排序算法 {

//    治-合并算法
    public static void Merge(int []a,int left,int index,int right)
    {

//        1.创建一个临时数组，用于临时存放当前问题的解
        int temp[] = new int[a.length];
//        2.将两个子数组的元素 逐个比较 放入临时数组内。
//        i_l 指向 子数组1的起点
//        i_r 指向 子数组2的起点
//        i_temp 指向 临时数组的起点
        int i_l = left, i_r=index+1, i_temp = left;

//        3.两个子数组 逐个比较，每次都将最小的元素放入临时数组。时间复杂度 O(n)
        while (i_l <= index && i_r <= right)
        {
            if (a[i_l] <= a[i_r])
            {
                temp[i_temp] = a[i_l];
                i_l++;
            }
            else {
                temp[i_temp] = a[i_r];
                i_r++;
            }
            i_temp++;
        }

//        4. 将未参与比较的元素，逐个放入临时数组内即可
//        未参与比较的元素，意味着大于所有的已参与比较的元素，将其放在临时数组接下来的位置即可
//        情况1：子数组1的剩余x个元素未参与比较
//        情况2：子数组2的剩余x个元素未参与比较
        if (i_l <= index)
        {
            while(i_l <= index)
            {
                temp[i_temp] = a[i_l];
                i_temp++;
                i_l++;
            }
        }
        else if (i_r <= right)
        {
            while(i_r <= right)
            {
                temp[i_temp] = a[i_r];
                i_temp++;
                i_r++;
            }
        }

//        5.将临时数组的有序元素 拷贝 到 数组a ，得到当前问题的解。
        for (int i = left;i <= right;i++)
        {
            a[i] = temp[i];
        }

    }

    public static void MergeSort(int []a, int left, int right)
    {
//        停止分解条件
        if (left == right)
        {
//            由于单个元素是天然有序的，所以不需要对叶子层做任何处理
//            System.out.println(a[right]);
            return;
        }

        if (left < right)
        {
//            分
//            1.找出当前问题 规模的中心
            int i = (left + right) / 2;
//            2.将其当前问题分为两个子问题，分别解决子问题
            MergeSort(a, left, i);
            MergeSort(a, i+1, right);

//            治
//            3.合并子问题的解，求出当前问题的解-即将两个有序的数组合并为一个的有序的数组
            Merge(a,left,i,right);
        }


    }
    public static void main(String[] args) {
//        int []a = {30,50,60,70,90,110,10};
        int []a = {1,5,98,1,5,6,9,8,436,59,20};

        MergeSort(a,0,a.length-1);

        for (int i= 0; i <a.length;i++)
        {
            System.out.print(a[i]);
            System.out.print(",");
        }
        System.out.println();
    }
}
