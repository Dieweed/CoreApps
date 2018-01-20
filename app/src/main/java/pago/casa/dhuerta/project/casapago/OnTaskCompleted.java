package pago.casa.dhuerta.project.casapago;

/**
 * Created by dhuerta on 11/10/2016.
 */
public interface OnTaskCompleted {

    public void onTaskCompleted(Object feed);
    public void onTaskError(Object feed);
}
