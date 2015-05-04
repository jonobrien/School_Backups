package command;

/**
 * This interface is responsible for declaring the needed
 * methods that a concrete command must implement;
 *		- execute() : does some action with a reciever
 */
interface CommandInterface {
	abstract public void execute();
}

