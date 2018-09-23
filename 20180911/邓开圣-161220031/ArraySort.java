package hw;
import java.util.*;	//����java.util��֧��������

public class ArraySort {
	String[] numString;	//�ַ�������,����֧�ֲ�ȷ�����ȵ���������
	int num[];			//int�͵�����
	ArraySort(){numString=null;num=null;};
	int partition(int left,int right) {	//�ָ�
		int p1=left,p2=right;
		int boundary=num[p1];
		while(p1<p2) {
			while((p1<p2)&&num[p2]>=boundary)
				p2--;
			num[p1]=num[p2];
			while((p1<p2)&&(num[p1]<=boundary))
				p1++;
			num[p2]=num[p1];
		}
		num[p1]=boundary;
		return p1;
	}
	void qsort(int left,int right) {	//��������
		if(left<right) {
			int pivot=partition(left,right);
			qsort(left,pivot-1);
			qsort(pivot+1,right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);	//��ʼ��Scanner
		ArraySort AS=new ArraySort();		//ʵ����һ��ArraySort����
		System.out.println("Please input an integer array(split by ' '):");
		AS.numString=in.nextLine().split(" ");	//���������ַ������Կո���Ϊ�ָ���
		in.close();		//�ر�������
		AS.num=new int[AS.numString.length];	//����������ַ���Ϊnum�����ڴ�ռ�
		for(int i=0;i<AS.numString.length;i++) {
			AS.num[i]=Integer.valueOf(AS.numString[i]);	//����Integer���valueOf�������ַ������н���
		}
		AS.qsort(0, AS.num.length-1);	//��������п�������
		System.out.println("Sorting result:");
		for(int a:AS.num) {	//��foreachѭ����������е�Ԫ��
			System.out.print(a+" ");
		}
	}

}

