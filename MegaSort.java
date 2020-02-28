import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class MegaSort{

	
	public static int partition(ArrayList<Integer> a,int start,int end){
		int pivot=end;
		int left=start-1;
		for(int j=start;j<=end;j++){
			if(a.get(j)<a.get(pivot)){
				left++;
				int temp=a.get(left);
				a.set(left,a.get(j));
				a.set(j,temp);
			}
		}
		int temp=a.get(left+1);
		a.set(left+1,a.get(pivot));
		a.set(pivot,temp);
		return left+1;
			
	}

	public static void qs(ArrayList<Integer> a,int start,int end){
		if(start<end){
			int p=partition(a,start,end);
			qs(a,start,p-1);
			qs(a,p+1,end);
		}
	}
	public static void main(String args[])throws Exception{
		File filen=new File(args[0]);
		Scanner s=new Scanner(filen);

		ArrayList<Integer> list=new ArrayList<Integer>();
		while(s.hasNext()){
			int n=s.nextInt();
			list.add(n);
		}
		s.close();
		qs(list,0,list.size()-1);
		System.out.println(list.get(0)+" "+list.get(1)+" "+list.get(2));
		
	}



	


}
