package edu.knoxcraft.turtle3d;

public class SampleProgram
{
    public static void main(String[] args) {
        Turtle3D t=Turtle3D.createTurtle("sample");
        t.forward(10);
        t.turnRight(90);
        System.out.println(t.getScript().toJSONString());
    }

}