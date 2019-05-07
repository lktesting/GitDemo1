public class HeadNode 
{
	static SingleLinkedListNode2 headnode = null;
	public static void main(String[] args) 
	{
		PrintLinkedList();
		AddNode(1);
		AddNode(2);
		AddNode(3);
		AddNode(4);

		PrintLinkedList();

		SingleLinkedListNode2 newnode = new SingleLinkedListNode2(15);
		SingleLinkedListNode2 lastnode = GetLastNode();
		lastnode.next = newnode;

	}


	public static void AddNode(int value)
	{
		SingleLinkedListNode2 node = new SingleLinkedListNode2(value);
		if(headnode == null)
		{
			headnode = node;
		}
		else
		{
			SingleLinkedListNode2 temp = GetLastNode();
			temp.next = node;	
		}
	}

	public static SingleLinkedListNode2 GetLastNode()
	{
		if(headnode == null)
		{
			System.out.print("HeadNode is null ");
			return null;
		}
		else
		{
			SingleLinkedListNode2 temp = headnode;
			for(;temp.next != null;temp = temp.next);
			return temp;
		}
	}

	public static void PrintLinkedList()
	{
		if(headnode != null)
		{
			SingleLinkedListNode2 temp = headnode;
			while(temp != null)
			{
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}
		else
		{
			System.out.println("Headnode is null");
		}
	}

	public static void AddNodeAfter(int value, int position)
	{
		int i = 0;
		SingleLinkedListNode2 node = new SingleLinkedListNode2(value);
		SingleLinkedListNode2 temp = headnode;
		for(;temp.next != null;temp = temp.next)
		{
			i++;
			if(i == position)

			{
				break;
			}
		}
		temp.next = node;
	}
}

class SingleLinkedListNode2
{
	SingleLinkedListNode2 next = null;

	int data;

	SingleLinkedListNode2(int d)
	{
		data = d;
	}
}