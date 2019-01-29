class BinaryTree{
     
      public String serialize(Node root,ArrayList<Integer>aa){
       if(root==null)
         return "-1";
       StringBuilder sb= new StringBuilder();
       sb.append(root.data);
       sb.append(",");
       sb.append(serialize(root.left, aa));
       sb.append(serialize(root.right, aa));
       return sb.toString();

       }
       public Node deSerialize(String data){
        return buildTreeFromArray(data.split(","),new int[]{0});
       }
       
       private Node buildTreeFromArray(String[] arr,int[] index){

         if(index[0] > arr.length || arr[index[0]].equals("-1")){
            index[0]++;
            return null;
         }
         Node node = new Node(Integer.parseInt(arr[index[0]++]));
          node.left = buildTreeFromArray(arr, index);
          node.right =buildTreeFromArray(arr, index);
 
        return node;
     
      }
}

	
