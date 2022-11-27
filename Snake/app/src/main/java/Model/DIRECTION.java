package Model;

public enum DIRECTION{
    LEFT(){
        @Override
        public void moveHead(Node head){
            head.setX(head.getX()-1);
        }
    }, 
    /**
     * ini gatau kenapa kebalik. 
     * dari yang aku pikir harusnya klo ynya minus, kebawah. 
     * tapi malah kebalik wkwkkw
     * 
     * OOOH gjd gjd, kan koordinat y tu 0 diatas max di bawah. 
     * jadi klo turun ditambah ynya, klo naik dikurangin ynya
     */
    DOWN(){
        @Override
        public void moveHead(Node head){
            head.setY(head.getY()+1);
        }
    }, 
    RIGHT(){
        @Override
        public void moveHead(Node head){
            head.setX(head.getX()+1);
        }
    }, 
    UP(){
        @Override
        public void moveHead(Node head){
            head.setY(head.getY()-1);
        }
    };

    public void moveHead(Node head){
        return;
    }
}
