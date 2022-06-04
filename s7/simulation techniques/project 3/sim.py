import simpy

def Traffic_Light(env): 
  
    while True: 
  
        print ("Light turns GRN at " + str(env.now)) 
          
        # Light is green for 25 seconds 
        yield env.timeout(25)         
  
        print ("Light turns YEL at " + str(env.now))
          
        # Light is yellow for 5 seconds 
        yield env.timeout(5) 
  
        print ("Light turns RED at " + str(env.now)) 
          
        # Light is red for 60 seconds 
        yield env.timeout(60) 
  
# env is the environment variable 
env = simpy.Environment()         
  
# The process defined by the function Traffic_Light(env) 
# is added to the environment 
env.process(Traffic_Light(env)) 
  
# The process is run for the first 180 seconds (180 is not included) 
env.run(until = 180) 

# --------------------------------------------------------

def test_store_sim(benchmark):
    def producer(env, store, n):
        for i in range(n):
            yield env.timeout(1)
            yield store.put(i)

    def consumer(env, store):
        while True:
            yield store.get()
            yield env.timeout(2)

    def sim():
        env = simpy.Environment()
        store = simpy.Store(env, capacity=5)
        for _ in range(2):
            env.process(producer(env, store, 10))
        for _ in range(3):
            env.process(consumer(env, store))
        env.run()
        return next(env._eid)

    num_events = benchmark(sim)
    assert num_events == 87 
    
# ----------------------------------------------------------------

"""
Carwash example.

Covers:

- Waiting for other processes
- Resources: Resource

Scenario:
  A carwash has a limited number of washing machines and defines
  a washing processes that takes some (random) time.

  Car processes arrive at the carwash at a random time. If one washing
  machine is available, they start the washing process and wait for it
  to finish. If not, they wait until they an use one.

"""
import random

import simpy


RANDOM_SEED = 42
NUM_MACHINES = 2  # Number of machines in the carwash
WASHTIME = 5      # Minutes it takes to clean a car
T_INTER = 7       # Create a car every ~7 minutes
SIM_TIME = 20     # Simulation time in minutes


class Carwash(object):
    """A carwash has a limited number of machines (``NUM_MACHINES``) to
    clean cars in parallel.

    Cars have to request one of the machines. When they got one, they
    can start the washing processes and wait for it to finish (which
    takes ``washtime`` minutes).

    """
    def __init__(self, env, num_machines, washtime):
        self.env = env
        self.machine = simpy.Resource(env, num_machines)
        self.washtime = washtime

    def wash(self, car):
        """The washing processes. It takes a ``car`` processes and tries
        to clean it."""
        yield self.env.timeout(WASHTIME)
        print("Carwash removed %d%% of %s's dirt." %
              (random.randint(50, 99), car))


def car(env, name, cw):
    """The car process (each car has a ``name``) arrives at the carwash
    (``cw``) and requests a cleaning machine.

    It then starts the washing process, waits for it to finish and
    leaves to never come back ...

    """
    print('%s arrives at the carwash at %.2f.' % (name, env.now))
    with cw.machine.request() as request:
        yield request

        print('%s enters the carwash at %.2f.' % (name, env.now))
        yield env.process(cw.wash(name))

        print('%s leaves the carwash at %.2f.' % (name, env.now))


def setup(env, num_machines, washtime, t_inter):
    """Create a carwash, a number of initial cars and keep creating cars
    approx. every ``t_inter`` minutes."""
    # Create the carwash
    carwash = Carwash(env, num_machines, washtime)

    # Create 4 initial cars
    for i in range(4):
        env.process(car(env, 'Car %d' % i, carwash))

    # Create more cars while the simulation is running
    while True:
        yield env.timeout(random.randint(t_inter - 2, t_inter + 2))
        i += 1
        env.process(car(env, 'Car %d' % i, carwash))


# Setup and start the simulation
print('Carwash')
print('Check out http://youtu.be/fXXmeP9TvBg while simulating ... ;-)')
random.seed(RANDOM_SEED)  # This helps reproducing the results

# Create an environment and start the setup process
env = simpy.Environment()
env.process(setup(env, NUM_MACHINES, WASHTIME, T_INTER))

# Execute!
env.run(until=SIM_TIME)

# -------------------------------------------------------------------------------------

#from SimPy.Simulation import *

class Car(Process):
  def __init__(self,name,cc):
     Process.__init__(self,name=name)
     self.cc = cc

  def go(self):
     print(now( ), self.name, "Starting")
     yield hold,self,100.0
     print(now( ), self.name, "Arrived")

initialize( )
c1  = Car("Car1",2000)       # a new car
activate(c1,c1.go( ),at=6.0) # activate at time 6.0
c2  = Car("Car2",1600)       # another new car
activate(c2,c2.go( ))        # activate at time 0
simulate(until=200)
print('Current time is ', now( )) # will print 106.0                               

