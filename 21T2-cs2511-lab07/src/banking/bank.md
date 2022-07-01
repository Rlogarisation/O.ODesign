1. Explain why the code is consistent with the preconditions and postconditions.
    Because precondition checks the expectation of the contract, and handle the cases within expectation. Postcondition implements the contract by assuming all preconditions are true. Hence cohesive relationship between precondition and postcondition, code must be consistent.
2. Explain why balance >= 0 is a class invariant for both classes.
    Because balance could only be greater and equal to zero in all situation, and that is the constraint for all execution in bank account.
3. Are your class definitions consistent with the Liskov Substitution Principle?
    Yes, the definitions consist with classes, since Liskov substitution principle defines objects of a superclass shall be replaceable with objects of its subclasses without breaking the application. That requires the objects of the subclasses to behave in the same way as the objects of superclass.