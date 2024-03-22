package SLMS;



/**
 *
 * @author Inshaf
 */
class memblist {
    private String name , address;
    private int index , tel;
    
    public memblist(int index , int tel, String name , String address){
        this.index = index;
        this.tel = tel;
        this.address = address;
        this.name = name;
    }
    public int getindex(){
        return index;
    }
    public int gettel(){
        return tel;
    }
    public String getname(){
        return name;
    }
    public String getaddress(){
        return address;
    }

    
    
}
