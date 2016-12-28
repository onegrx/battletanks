package edu.paszgr.persistence;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {
    private boolean append = false;

    protected AppendableObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        if (append) {
            reset();
        } else {
            super.writeStreamHeader();
        }
    }

    public void writeObjectOrAppend(Object obj, boolean append) throws IOException {
        this.append = append;
        super.writeObject(obj);
    }
}
