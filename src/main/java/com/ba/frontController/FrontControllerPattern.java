package com.ba.frontController;

class FrontControllerPattern
{
    public static void main(String[] args)
    {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("Teacher");
        frontController.dispatchRequest("Student");
    }
}
