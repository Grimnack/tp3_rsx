JC = javac                           

all: ReceiveUDP.class SendUDP.class

ReceiveUDP.class: ReceiveUDP.java
	$(JC) $^

SendUDP.class: SendUDP.java
	$(JC) $^

test: ReceiveUDP.class SendUDP.class
	java ReceiveUDP 1500 &
	java SendUDP localhost 1500 "test réussi"

clean:
	rm -rf *.class *~
