package org.example.candycrushproyect.Factory;

import org.example.candycrushproyect.Dulce;

public class DulceFactory implements Factory{

    @Override
    public Dulce GenerarDulce(int x) {
        return new Dulce(x);
    }
}
