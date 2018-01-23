
import sun.java2d.pipe.PixelDrawPipe;

import java.security.cert.Extension;
import java.util.Stack;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Homework1 {
	public static  Node tree ;
	public static Stack<Character> Box =new Stack<Character>();
	public static void main(String[] args) {

		//String input = "251-*32*+";

		String posfix = args[0];
		for(int i=0;i<posfix.length();i++){
			Box.add(posfix.charAt(i));
		}
		tree = new Node(Box.pop());
		Infix(tree);
		iNorder(tree);
		System.out.print("="+Calculate(tree));

	}
	public static void Infix(Node Pisit){
		if(Pisit.Mind == '+' || Pisit.Mind == '-' || Pisit.Mind == '*' || Pisit.Mind == '/'){
			Pisit.right = new Node(Box.pop());
			Infix(Pisit.right);
			Pisit.left = new Node(Box.pop());
			Infix(Pisit.left);
		}
	}
	public static int Calculate(Node Dota){
		if(Dota.Mind == '+')
		{
			return Calculate(Dota.left)+Calculate(Dota.right);
		}
		else  if(Dota.Mind == '-')
		{
			return Calculate(Dota.left)-Calculate(Dota.right);
		}
		else  if(Dota.Mind == '*')
		{
			return Calculate(Dota.left)*Calculate(Dota.right);
		}
		else  if(Dota.Mind == '/')
		{
			return  Calculate(Dota.left)/Calculate(Dota.right);
		}
		else return Integer.parseInt(Dota.Mind.toString());
	}

	public static void iNorder(Node Hong) {
		if(Hong.Mind == '+' || Hong.Mind == '-' || Hong.Mind == '*' || Hong.Mind == '/'){
			if(Hong!=tree)System.out.print("(");
			iNorder(Hong.left);
			System.out.print(Hong.Mind);
			iNorder(Hong.right);
			if(Hong!=tree)System.out.print(")");
		}else
		{
			System.out.print(Hong.Mind);
		}
	}

/// test commit again
}
