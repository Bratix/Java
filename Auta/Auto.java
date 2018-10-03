public  class Auto{
  String prv,marka,kategorija;
  int id;
  Auto(int id,String prv,String marka,String kategorija){
    this.id=id;
    this.prv=prv;
    this.marka=marka;
    this.kategorija=kategorija;
  }
  Auto(){};
  public String toString()
  {
    return id + "-" + prv + "-" + marka + "-" + kategorija;
  }
}