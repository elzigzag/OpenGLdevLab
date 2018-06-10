package vector3.mx.skinnerapp;

import android.content.Context;

import static android.opengl.GLES20.glUseProgram;

/**
 * Created by miMiau on 07/04/2018.
 */

public class ShaderProgram {
    //Uniform Constants
    protected static final String  U_MATRIX = "u_Matrix";
    protected static final String  U_TEXTURRE_UNIT = "u_TextureUnit";
    //Atribute Constants
    protected static final String A_POSITION = "a_Position";
    protected static final String A_COLOR = "a_Color";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";
    //Shader Program
    protected final int program;

    public ShaderProgram(Context context, int vertexShaderResourceId,
                         int fragmentShaderResourceId) {
        //Compile the shaders and link the program
        program = ShaderHelper.buildProgram(
                TextResourceReader.readTextFileFromResource(
                        context, vertexShaderResourceId),
                TextResourceReader.readTextFileFromResource(
                        context, fragmentShaderResourceId)
        );
    }

    public void useProgram(){
        //Set the current openGl Shader Program to this program.
        glUseProgram(program);
    }
}
