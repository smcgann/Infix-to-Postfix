public class Converter 
{	
	
	public static int priorityCheck (String token)
	{
		int priorityValue = 0;
		
		if (token.equals("*") || token.equals("/"))
		{
			priorityValue = 2;
		}
		else if (token.equals("+") || token.equals("-"))
		{
			priorityValue = 1;
		}
		else if (token.equals("("))
		{
			priorityValue = 3;
		}
		else if (token.equals(")") || token.equals("#"))
		{
			priorityValue = 0;
		}
		else
		{
			priorityValue = 4;
		}
		
		return priorityValue;
	}
	
	public static LLQueue tokenize(String infix)
	{
		LLQueue infixQueue = new LLQueueADT();
		
		String[] infixQueue2 = infix.split(" ");
		
		for (int i=0; i<infixQueue2.length; i++) 
		{
			infixQueue.enqueue(infixQueue2[i]);
		}
		return infixQueue;
	} 
	
	public static LLQueue converterAct(String infix)
	{
		System.out.println("\nInfix equation: " + infix);
		LLQueue input = tokenize(infix);
		LLStack operators = new LLStackADT();
		LLQueue output = new LLQueueADT();
		
		int size = input.size();
		
		operators.push("#");
		String nextToken = input.dequeue();
		
		for(int i = 0; i<size; i++)
		{			
			if (priorityCheck(nextToken) != 4)
			{
				if (nextToken == ")")
				{
					while(nextToken != "(")
					{
						output.enqueue(nextToken);
					}
				}
				else
				{
					if (operators.empty() == true)
					{
						operators.push(nextToken);
					}
					else if(priorityCheck(operators.onTop()) > priorityCheck(nextToken))
					{
						output.enqueue(operators.pop());
						operators.push(nextToken);
					}
					else
					{
						operators.push(nextToken);
					}
				}
			}
			else 
			{
				output.enqueue(nextToken);
			}
			if (input.empty() != true)
			{
				nextToken = input.dequeue();
			}
		}
		while (operators.onTop() != "#")
		{
			output.enqueue(operators.pop());
		}
		return output;

	}
	
	public static String calculate(LLQueue postfix)
	{
		LLStack outputStack = new LLStackADT();
		int result = 0;
		while(postfix.empty() != true)
		{
			String token = postfix.dequeue();
			
			if (priorityCheck(token) == 4)
			{
				outputStack.push(token);
			}
			else
			{
				int op2 = Integer.parseInt(outputStack.pop());
				int op1 = Integer.parseInt(outputStack.pop());
				
				int opIdentifier = priorityCheck(token);
				switch (opIdentifier)
				{
					case 1:
						if (token.equals("+"))
						{
							result = op1 + op2;
						}
						else
						{
							result = op1 - op2;
						}
						break;
					case 2:
						if (token.equals("*"))
						{
							result = op1 * op2;
						}
						else
						{
							result = op1 / op2;
						}
						break;
				}
				outputStack.push(Integer.toString(result));	
			}
		}
		return outputStack.pop();
			
	}
}
