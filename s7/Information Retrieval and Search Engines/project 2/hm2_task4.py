"""
Κωδικοποίηση variable byte (με 8 bit blocks). 
Το πρόγραμμα θα παίρνει ως όρισμα έναν ακέραιο (>0) και θα επιστρέφει τον αντίστοιχο variable byte code.
"""

def checkAndGetInputNumber(message, necessary_type):
  """
  Η συνάρτηση checkAndGetInputNumber δέχεται μια είσοδο από τον χρήστη, προβάλλοντάς του το μήνυμα message
  και όσον αφορά το όρισμα necessary_type, όταν περαστεί παράμετρος "int" ελέγχει την είσοδο να είναι αριθμός, ακέραιος, μεγαλύτερος του μηδενός
  """

  # define Python user-defined exceptions
  class Error(Exception):
    """Base class for other exceptions"""
    pass
  
  class ValueNoGreaterThanZero(Error):
    """Raised when the input value is <=0 """
    pass
  
  class ValueNoInteger(Error):
    """Raised when the input value is float """
    pass

  while True:
    input_value = input(message)

    try:
      input_value = float(input_value)
      if necessary_type=="int":
        if input_value<=0:
          raise ValueNoGreaterThanZero
        if input_value.is_integer():
          input_value = int(input_value)
        else:
          raise ValueNoInteger
    except ValueError:
      print("\n Τα δεδομένα που δόθηκαν δεν είναι αριθμός. Ξαναπροσπάθησε. \n")
    except ValueNoGreaterThanZero:
      print("\n Ο αριθμός που δόθηκε δεν είναι μεγαλύτερος του μηδενός. Ξαναπροσπάθησε. \n")
    except ValueNoInteger:
      print("\n Ο αριθμός που δόθηκε δεν είναι ακέραιος. Ξαναπροσπάθησε. \n")
    except RuntimeError: 
      # Raised when an error does not fall under any other category
      print ("\n Κάτι πήγε λάθος, ξαναπροσπάθησε. \n")
    else:
      return input_value

def hr():
  print('─' * 20)

def Binary_Representation(x):
  binary = "{0:b}".format(int(x))
  return binary

def VariableByteEncode(x):
  bin = Binary_Representation(x)
  if x<=127:
    variableByte = '1'+ (8-len(bin)-1)*'0' + bin
  else:
    FirstTime = True
    while len(bin)!=0:
      if FirstTime:
        # τρέχει μόνο στην περίπτωση μεγαλύτερου του ενός byte αριθμού, την πρώτη φορά
        variableByte = '1' + bin[-7:] # κράτα τα 7 τελευταία bits, με 1 στην αρχή 
        bin = bin[:-7]
        FirstTime = False
      else:
        if len(bin)>7:
          variableByte = '0' + bin[-7:] + variableByte
          bin = bin[:-7]
        else:
          variableByte = '0'+ (8-len(bin)-1)*'0' + bin + variableByte
          bin = ''
  return variableByte
  
hr()

number = checkAndGetInputNumber('Give a number to calculate the variable byte code ',"int")
print('The variable byte code for your number is', VariableByteEncode(number))

hr()
input('Press enter to continue')