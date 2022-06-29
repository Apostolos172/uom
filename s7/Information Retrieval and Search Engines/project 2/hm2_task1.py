"""
Κωδικοποιήσεις γ-code, δ-code και variable byte code
"""

def hr():
  print('─' * 20)

def UnaryEncode(lengthOfx):
  return (lengthOfx)*'1'+'0'

def Binary_Representation(x):
  binary = "{0:b}".format(int(x))
  return binary

def Binary_Representation_Without_MSB(x):
  binary = Binary_Representation(x)
  binary_without_MSB = binary[1:]
  return binary_without_MSB

def EliasGammaEncode(k):
  offset = Binary_Representation_Without_MSB(k)
  length = len(offset)
  UnaryLength = UnaryEncode(length)
  return UnaryLength + offset
  
def EliasDeltaEncode(x):
  offset = Binary_Representation_Without_MSB(x)
  length = len(offset)
  GammaLength = EliasGammaEncode(length)
  return GammaLength + offset

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

postings_list = [42, 59, 81, 85, 99, 300, 303]
gap_list = [42, 17, 22, 4, 14, 201, 3]

gamma = ''
delta = ''
byte = ''
firstTime = True
for gap in gap_list:
  gamma+=EliasGammaEncode(gap)
  delta+=EliasDeltaEncode(gap)
  byte+=VariableByteEncode(gap)
  if firstTime:
    print('posting', gap)
    firstTime = False;
  else:
    print('gap', gap)
  print('gamma code ' + EliasGammaEncode(gap))
  print("delta code " + EliasDeltaEncode(gap))
  print("byte code " + VariableByteEncode(gap))
  print('\n')

hr()
print('gamma',gamma,'\nbits gamma:',len(gamma),'\nbytes gamma:',len(gamma)/8,'\n')
print('delta',delta,'\nbits delta:',len(delta),'\nbytes delta:',len(delta)/8,'\n')
print('byte',byte,'\nbits VB:',len(byte),'\nbytes VB:',len(byte)/8,'\n')

hr()
input('Press enter to continue')
