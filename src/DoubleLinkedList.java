
public class DoubleLinkedList 
{
	static DoubleLinkedListNode HeadNode;
	static DoubleLinkedListNode TailNode;
	
	public static void main(String[] args)
	{
		
		AddNewNode(5);
		AddNewNode(13);
		AddNewNode(1);
		AddNewNode(99);
		PrintNodesForward();
		PrintNodesBackward();
	}
	
	private static void PrintNodesForward() 
	{
		if(HeadNode != null)
		{
			System.out.println("Printing List Forward");
			DoubleLinkedListNode temp = HeadNode;
			while(temp != null)
			{
				System.out.println(temp.Data + " ");
				temp = temp.Next;
			}
		}
		else
		{
			System.out.println("List is Empty ");
		}
	}
	
	private static void PrintNodesBackward() 
	{
		if(TailNode != null)
		{
			System.out.println("Printing List Backward");
			DoubleLinkedListNode temp = TailNode;
			while(temp != null)
			{
				System.out.println(temp.Data + " ");
				temp = temp.Previous;
			}
		}
		else
		{
			System.out.println("List is Empty ");
		}
	}

	static void AddNewNode(int value)
	{
		DoubleLinkedListNode new_node = new DoubleLinkedListNode(value);
		if(HeadNode == null && TailNode == null)
		{
			HeadNode = new_node;
			TailNode = new_node;
		}
		else
		{
			new_node.Previous = TailNode;
			TailNode.Next = new_node;
			TailNode = new_node;
		}
	}
}

class DoubleLinkedListNode
{
	int Data;
	DoubleLinkedListNode Previous = null;
	DoubleLinkedListNode Next = null;
	
	DoubleLinkedListNode(int data)
	{
		Data = data;
	}
}