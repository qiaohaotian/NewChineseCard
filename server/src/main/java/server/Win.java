package server;

import java.util.ArrayList;

public class Win {
    public static boolean ishule(ArrayList<Card> handcard){
        handcard = Rules.sorthandcard(handcard);
        boolean a=false;


        for(int i=0;i<handcard.size()-1;i++){
            ArrayList<Card> handcard1 = new ArrayList<Card>();
            for(int j=0;j<handcard.size();j++){
                Card orginal = handcard.get(j);
                Card shadow = new Card(orginal.getNumber(),orginal.getColor(),orginal.getNo());
                handcard1.add(shadow);
            }
            if(handcard.get(i).issame(handcard.get(i+1))){
                handcard1.remove(i);
                handcard1.remove(i);
                a = check(handcard1);
                if (a==true){
                    break;
                }
            }
        }
        return a;
    }
    private static boolean check(ArrayList<Card> handcard){
        boolean a = false;
        if(handcard.size()==0){
            a = true;
        }else if(!isKezi(handcard)&!isShunzi(handcard)){
            a = false;
        }else{
            if(isKezi(handcard)){
                takeKezi(handcard);
                a=check(handcard);
            }else{
                takeShunzi(handcard);
                a=check(handcard);
            }
        }
        return a;
    }
    private static boolean isShunzi(ArrayList<Card> handcard) {
        boolean a= false;
        for(int i=0;i<handcard.size()-2;i++){
            if(handcard.get(i).getNo()==handcard.get(i+1).getNo()-1&handcard.get(i).getNo()==handcard.get(i+2).getNo()-2){
                if(handcard.get(i).getColor().equals(handcard.get(i+1).getColor())&handcard.get(i).getColor().equals(handcard.get(i+2).getColor())){
                    a = true;
                    break;
                }
            }
        }
        return a;
    }
    public static void takeKezi(ArrayList<Card> handcard){
        for(int i = 0;i<handcard.size()-1;i++){
            if(handcard.get(i).issame(handcard.get(i+1))&handcard.get(i).issame(handcard.get(i+2))){
                handcard.remove(i);
                handcard.remove(i);
                handcard.remove(i);
                break;
            }
        }
    }
    public static void takeShunzi(ArrayList<Card> handcard){
        for(int i=0;i<handcard.size()-1;i++){
            if(handcard.get(i).getNo()==handcard.get(i+1).getNo()-1&handcard.get(i).getNo()==handcard.get(i+2).getNo()-2){
                if(handcard.get(i).getColor().equals(handcard.get(i+1).getColor())&handcard.get(i).getColor().equals(handcard.get(i+2).getColor())){
                    handcard.remove(i);
                    handcard.remove(i);
                    handcard.remove(i);
                    break;
                }
            }
        }
    }
    public static boolean isKezi(ArrayList<Card> handcard){
        boolean a = false;
        for(int i = 0;i<handcard.size()-2;i++){
            if(handcard.get(i).issame(handcard.get(i+1))&handcard.get(i).issame(handcard.get(i+2))){
                a = true;
                break;
            }
        }
        return a;
    }
}
