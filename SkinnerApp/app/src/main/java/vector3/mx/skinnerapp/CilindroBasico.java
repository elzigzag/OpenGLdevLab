package vector3.mx.skinnerapp;

import java.util.List;

public class CilindroBasico {

    private static final int POSITION_COMPONENT_COUNT = 3;
    private static final int COLOR_COMPONENT_COUNT = 3;
    private static final int STRIDE = ( POSITION_COMPONENT_COUNT
            + COLOR_COMPONENT_COUNT ) * Constants.BYTES_PER_FLOAT;
    public final float radius;
    private final VertexArray vertexArray;
    private final List<ObjectBuilder.DrawCommand> drawList;

    public CilindroBasico(float radius, float height, int numPoints){
        this.radius = radius;
        ObjectBuilder.GeneratedData generatedData = ObjectBuilder.createCilindro(
                new Geometry.Cylinder(
                        new Geometry.Point(0.0f, 0.0f, 0.0f), radius, height),
                numPoints
                );
        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public void bindData(ColorShaderProgram colorProgram){
        vertexArray.setVertexAttribPointer(
                0,
                colorProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT,
                STRIDE);
        vertexArray.setVertexAttribPointer(
                POSITION_COMPONENT_COUNT,
                colorProgram.getaColorAttributeLocation(),
                COLOR_COMPONENT_COUNT,
                STRIDE);

    }

    public void draw(){
        for ( ObjectBuilder.DrawCommand drawCommand : drawList ){
            drawCommand.draw();
        }
    }

}
