public class test 
{
	public static void main (String[] args)
	{
		//example1
		String expression1 = "5 * 3 + 6 - 8 / 2";

		//example 1 converting infix to postfix
		LLQueue output1 = Converter.converterAct(expression1);
		int size1 = output1.size();

		System.out.println("\nOutput list: ");
		for (int i = 0; i < size1; i++)
		{
			System.out.println(output1.dequeue());
		}
		 
		//example 1 calculating postfix
		LLQueue output2 = Converter.converterAct(expression1);
		System.out.println("Result: " + Converter.calculate(output2));
		
		//example 2
		String expression2 = "5 + 3 - 6";

		//example 2 converting infix to postfix
		LLQueue output3 = Converter.converterAct(expression2);
		int size2 = output3.size();

		System.out.println("\nOutput list: ");
		for (int i = 0; i < size2; i++)
		{
			System.out.println(output3.dequeue());
		}
		 
		//example 2 calculating postfix
		LLQueue output4 = Converter.converterAct(expression2);
		System.out.println("Result: " + Converter.calculate(output4));
	}
}
