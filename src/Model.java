
import java.util.Arrays;
import java.util.Objects;



/**
 *
 * @author Gabo Quesada
 */
public class Model {
    
    private String nombre;
    private String edad;
    private String [] array;
    private String server;

    /**
     *
     */
    public Model() {
    }

    public Model(String nombre, String edad, String[] array, String server) {
        this.nombre = nombre;
        this.edad = edad;
        this.array = array;
        this.server = server;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.edad);
        hash = 97 * hash + Arrays.deepHashCode(this.array);
        hash = 97 * hash + Objects.hashCode(this.server);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Model other = (Model) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        if (!Objects.equals(this.server, other.server)) {
            return false;
        }
        if (!Arrays.deepEquals(this.array, other.array)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model{" + "nombre=" + nombre + ", edad=" + edad + ", array=" + array + ", server=" + server + '}';
    }

    
    
}
