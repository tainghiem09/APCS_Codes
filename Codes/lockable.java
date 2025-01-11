public interface lockable
{
    public void setkey (int pass);
    public void lock ( int locker);
    public void unlock(int unlocker);
    public boolean locked ();
} 