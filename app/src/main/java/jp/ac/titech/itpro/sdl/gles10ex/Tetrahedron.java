package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class  Tetrahedron implements SimpleRenderer.Obj {

    private final static float[] VERTICES = {
            //bottom tri
            0,0,0,
            1,1,0,
            0,1,-1,
            //tri2
            1,1,0,
            0,1,-1,
            1,0,-1,
            //tri3
            0,1,-1,
            1,0,-1,
            0,0,0,
            //tri4
            1,0,-1,
            0,0,0,
            1,1,0,
    };

    private final FloatBuffer vbuf;

    Tetrahedron() {
        vbuf = ByteBuffer.allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // tri1
        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // tri2
        gl.glNormal3f(-1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // tri3
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // tri4
        gl.glNormal3f(-1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

    }

}
