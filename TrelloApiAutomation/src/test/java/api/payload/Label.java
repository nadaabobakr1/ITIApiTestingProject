package api.payload;

public class Label {

    String id="";
    String idBoard="";
    String name="";
    String color="";

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLabelColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getIdBoard() {
        return idBoard;
    }
    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
