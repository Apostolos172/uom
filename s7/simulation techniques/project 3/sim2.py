
import numpy as np

class Simulation:
    def __init__(self):
        self.num_in_system = 0
        
        self.clock = 0.0
        self.t_arrival = self.generate_interarrival()
        self.t_depart = float('inf')
        
        self.num_arrivals = 0
        self.num_departs = 0
        self.total_wait = 0.0
        
    def advance_time(self):
        t_event = min(self.t_arrival, self.t_depart)
        
        self.total_wait += self.num_in_system*(t_event - self.clock)
        
        self.clock = t_event
        
        if self.t_arrival <= self.t_depart:
            self.handle_arrival_event()
        else:
            self.handle_depart_event()
        
    def handle_arrival_event(self):
        # διαχείριση γεγονότος άφιξης
        self.num_in_system+=1
        self.num_arrivals+=1
        if self.num_in_system <= 1:
            self.t_depart = self.clock + self.generate_service()
        self.t_arrival = self.clock +self.generate_interarrival()
        
    def handle_depart_event(self):
        # διαχείριση γεγονότος αναχώρησης
        self.num_in_system -= 1
        self.num_departs += 1
        if self.num_in_system > 0:
            self.t_depart = self.clock + self.generate_service()
        else:
            self.t_depart = float('inf')
        
    def generate_interarrival(self):
        # παραγωγή εισερχόμενων πελατών
        # 1 customer per 7 minutes on average
        return np.random.exponential(7./1) 
        
    def generate_service(self):
        # παραγωγή χρόνου εξυπηρέτησης
        # 1 customer per 4 minutes on average
        return np.random.exponential(4./1)
     
np.random.seed(0)
     
s = Simulation()

# for the first 100 events
for i in range(100):
    s.advance_time()
    #print(s.generate_interarrival())
    
print('\n')
print('Συνολικές αφίξεις πελατών:',s.num_arrivals)
print('Συνολικές αναχωρήσεις πελατών:',s.num_departs)
print('Συνολικός χρόνος αναμονής πελατών:',s.total_wait)
print('Μέσος χρόνος αναμονής ενός πελάτη:',s.total_wait/s.num_departs)
print('\n')
