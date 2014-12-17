package org.losi.vistas.componentes;

import java.util.HashMap;

public interface Formulario {
    
    public HashMap<String,Object> getDatos();
    
    public boolean isDatosOk();
    
    public void setDatosOk(boolean valor);
    
}
