import greenfoot.*;
public class DK extends Actor
{
    long lastTime;
    GreenfootImage dkIdle1 = new GreenfootImage("donkey-kong_standing.png");
    GreenfootImage dkThrow = new GreenfootImage("Donkey_Kong_Classic_NES_Artwork.png");
    GreenfootImage dkIdle2 = new GreenfootImage("donkeyIdle2.png");
    public void act() 
    {
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());

            Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTime > 2500)
        {
            setImage(dkThrow);
            dkThrow.scale(100, 100);
            lastTime = System.currentTimeMillis();
            getWorld().addObject(new Barrel(), getX(), getY());
        }else if(System.currentTimeMillis() - lastTime > 1500){
            setImage(dkIdle1);
        }
    }    
}