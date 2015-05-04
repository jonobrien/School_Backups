"""
A class to represent an exception using the skewer

Author: Sean Strout
Author: Jon O'Brien

"""
class SkewerException(Exception):
    """
    Class: SkewerException
    Description: Used to represent the various exceptions that can
        happen when dealing with the skewer.
    Slots:
        self - SkewerException instance being created
        msg - the message (string) associated with the exception
    """

    __slots__ = ()

    def __init__(self, msg):
        """
        Construct an exception.
        Arguments:
            self - SkewerException instance being created
            msg - the message (string) associated with the exception
        """
        self.msg = msg
        
    def __str__(self):
        """
        Get the exception message.
        Arguments:
            self - SkewerException instance being created
        Returns: the message (string) associated with the exception.
        """
        return self.msg
