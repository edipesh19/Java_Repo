package com.adapter2;
class Rectangle implements Shape
{
    private LegacyRectangle adaptee = new LegacyRectangle();
    private RoundRectangle adapteeOne = new RoundRectangle();
    public void draw(int x1, int y1, int x2, int y2)
    {
        adaptee.draw(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1),
          Math.abs(y2 - y1));
    }
    
    public Object getAdapter(String clsName){
    	if(clsName.equals("LegacyRectangle"))
    		return adaptee;
    	if(clsName.equals("RoundRectangle"))
    		return adapteeOne;
    	return null;
    }
}