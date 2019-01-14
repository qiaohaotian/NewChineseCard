package client;

import java.util.ArrayList;

public class Rules {
	public static ArrayList<Card> groupby(ArrayList<Card> handcards, String type){
		ArrayList<Card> sorted = new ArrayList<Card>();
		
		for(int i=0;i<handcards.size();i++){
			if(handcards.get(i).getColor().equals(type)){
				sorted.add(handcards.get(i));
			}
		}
		return sorted;
	}
	public static ArrayList<Card> sorthandcard(ArrayList<Card> handcards) {
		ArrayList<Card> sorted = new ArrayList<Card>();
		//分组
		ArrayList<Card> tiaosorted = groupby(handcards,"条");
		ArrayList<Card> bingsorted = groupby(handcards,"饼");		
		ArrayList<Card> wansorted = groupby(handcards,"万");
		ArrayList<Card> fengsorted = groupby(handcards,"风");
		ArrayList<Card> sesorted = groupby(handcards,"色");

		tiaosorted = sort(tiaosorted);
		bingsorted = sort(bingsorted);
		wansorted = sort(wansorted);
		fengsorted = sort(fengsorted);
		sesorted = sort(sesorted);
		sorted.addAll(tiaosorted);
		sorted.addAll(bingsorted);
		sorted.addAll(wansorted);
		sorted.addAll(fengsorted);
		sorted.addAll(sesorted);
		return sorted;
	}
	//排序方法
	private static ArrayList<Card> sort(ArrayList<Card> cards){
		//ArrayList<Card> handcard = sorthandcard(cards);

		Object[] unsorted = cards.toArray();
		Object temp;
		for(int i =0;i<unsorted.length;i++){
			for(int j=i+1;j<unsorted.length;j++){
				if(((Card)unsorted[i]).biggerthan((Card)unsorted[j])){
					temp = unsorted[i];
					unsorted[i]=unsorted[j];
					unsorted[j]=temp;
				}
			}
		}
		ArrayList<Card> sorted = new ArrayList<Card>();		
		for(int i=0;i<unsorted.length;i++){
			sorted.add((Card)unsorted[i]);
			
		}
		return sorted;
	}
	public static boolean judgement(Card lastcard,ArrayList<Card> handcard){
		ArrayList<Card> sorted = groupby(handcard,lastcard.getColor());
		boolean a = false;
		int w = lastcard.getNo() - 1;
		int x = lastcard.getNo() - 2;
		int y = lastcard.getNo() + 1;
		int z = lastcard.getNo() + 2;
		if(judge(w,sorted)&judge(x,sorted)){
			a=true;
		}else if(judge(w,sorted)&judge(y,sorted)){
			a=true;
		}else if(judge(y,sorted)&judge(z,sorted)){
			a=true;
		}
		return a;
	}
	private static  boolean judge(int a,ArrayList<Card> sorted){
		boolean b = false;
		for(int i=0;i<sorted.size();i++){
			if(sorted.get(i).getNo()==a){
				b = true;
			}
		}
		return b;
	}
	public static String transformStr(ArrayList<Card> handcard){
		String a = "";
		for(int i=0;i<handcard.size();i++){
			a=a+handcard.get(i).transform();
		}
		return a;
	}
	public static ArrayList<Card> transformArr(String inStr){
		ArrayList<Card> handcard = new ArrayList<Card>();
		String[] ss =new String[1000];
		ss=inStr.split(" ");
		for(int i=0;i<ss.length;i=i+3){
			Card card = new Card(ss[i],ss[i+1],Integer.parseInt(ss[i+2]));
			handcard.add(card);
		}
		return handcard;
	}
}
