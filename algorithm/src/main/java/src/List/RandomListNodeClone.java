package src.List;

//复杂链表的复制
public class RandomListNodeClone {

    public void CloneNode(RandomListNode pHead) {
        RandomListNode temp;
        RandomListNode nowNode = pHead;
        while (nowNode != null) {
            temp = new RandomListNode(nowNode.label);
            temp.next = nowNode.next;
            //temp.random = null;
            nowNode.next = temp;
            nowNode = nowNode.next.next;
        }
    }

    public void ConnectRandom(RandomListNode pHead) {
        RandomListNode nowNode = pHead;

        while (nowNode != null) {
            RandomListNode clondeNode = nowNode.next;
            if (nowNode.random != null) {
                clondeNode.random = nowNode.random.next;
            }
            nowNode = nowNode.next.next;
        }
    }

    public RandomListNode splitRandomList(RandomListNode pHead) {
        RandomListNode pCloneHead = pHead.next;
        RandomListNode tmp;
        RandomListNode currNode = pHead;
        while (currNode.next != null) {
            tmp = currNode.next;
            currNode.next = tmp.next;
            currNode = tmp;
        }
        return pCloneHead;
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        CloneNode(pHead);//复制第一个链表正常链表
        ConnectRandom(pHead);//将复杂指针复制
        return splitRandomList(pHead);//拆分两个链表


    }
}
