from flask import Flask
from flask import request
from flask import jsonify
import requests
from Machine import Machine
import pika
import time
import os

app = Flask(__name__)

mycounter = 0


# apsched = BackgroundScheduler()
#



@app.before_first_request
def initialize():
    return
    # apsched.add_job(background_loop, 'interval', seconds=delay)
    # apsched.start()


@app.route("/history")
def history():
    return """<!DOCTYPE html>
                <html>
                <head>
                <title>Page Title</title>
                </head>
                <body>

                <h1>My First Heading</h1>
                <p>My first paragraph.</p>

                </body>
                </html>"""


@app.route("/")
def root():
    return m.retriveValue(), 200, {'Content-Type': 'application/json'}


@app.route("/help")
def help():
    print "Giving Help, similar to /stats"
    print "Some changed code"
    print m.statistics()
    return "Vending Machine Simulator API\nNew message\nCounter %i\n%s" % (mycounter, m.statistics()), 200, {
        'Content-Type': 'application/json'}



@app.route("/use/ingredient")
def useIngredient():
    # /use/ingredient?level_id=0&amount=3
    id = int(request.args.get('level_id', '0'))
    amount = int(request.args.get('amount', '0'))
    m.ingredient(id, amount)
    print id, amount
    retval = {"status": "amount"}
    # return "Refilled everything", 200, {'Content-Type': 'application/json'}
    return jsonify(**retval)

@app.route('/order', methods=['GET', 'POST'])
def order():
    if request.method == 'POST':
        print "POST"
        data = request.json
        for element in data["data"]:
            print element
            print element["id"]
            print element["value"]
            m.ingredient(int(element["id"]), int(element["value"]))
        m.nextIteration()

        return m.retriveValue(), 200, {'Content-Type': 'application/json'}
    else:
        print "GET"
        retval = {"status": "GET not supported"}
        return jsonify(**retval), 403, {'Content-Type': 'application/json'}


@app.route("/order2")
def order2():
    m.nextIteration()
    return m.retriveValue(), 200, {'Content-Type': 'application/json'}


@app.route("/refill")
def refill():
    m.machineRefill()
    retval = {"status": "Refilled everything"}
    #return "Refilled everything", 200, {'Content-Type': 'application/json'}
    return m.retriveValue(), 200, {'Content-Type': 'application/json'}
    return jsonify(**retval)

@app.route("/clean")
def clean():
    m.clean()
    #return "Everything clean and shiny now", 200, {'Content-Type': 'application/json'}
    retval = {"status": "Everything clean and shiny now"}
    return jsonify(**retval)


@app.route("/stats")
def stats():
    result = m.statistics()
    return result, 200, {'Content-Type': 'application/json'}


@app.route("/reset")
def myreset():
    m.resetmachine()
    #return "Reset machine", 200, {'Content-Type': 'application/json'}
    retval = {"status": "Reset done"}
    return jsonify(**retval)


# @app.route("/suspend")
# def suspend():
#    apsched.pause()
#    msg = "Suspended generation of events"
#    #return msg , 200, {'Content-Type': 'application/json'}
#    retval = {"status": "Suspended generation of events"}
#    return jsonify(**retval)


# @app.route("/resume")
# def resume():
#    apsched.resume()
#    #return "Resumed generation of events", 200, {'Content-Type': 'application/json'}
#    retval = {"status": "Resumed generation of events"}
#    return jsonify(**retval)

if __name__ == "__main__":

    def background_loop():
        global mycounter
        mycounter = mycounter + 1
        channel.basic_publish(exchange='',
                              routing_key=queue,
                              body=m.nextIteration())
        return


    def connect(myhost, myport, myuser, mypasswd, myqueue='HackZurich16', maxRetries=6):
        myconnection = None
        errorCount = 1
        while (myconnection is None) and (errorCount < maxRetries):
            print "Connection attempt ", errorCount
            try:
                credentials = pika.PlainCredentials(myuser, mypasswd)
                myconnection = pika.BlockingConnection(
                    pika.ConnectionParameters(host=myhost, port=myport, credentials=credentials))
            except:
                myconnection = None
                errorCount += 1
                time.sleep(15)
        mychannel = myconnection.channel()
        mychannel.queue_declare(queue=myqueue)

        return myconnection, mychannel


    host = os.environ.get('RABBITMQ_HOST', "64.100.10.242")
    delay = int(os.environ.get('DELAY', '20'))
    rabbitport = int(os.environ.get('RABBITMQ_PORT', '15001'))
    user = os.environ.get('RABBITMQ_DEFAULT_USER', "cisco")
    passwd = os.environ.get('RABBITMQ_DEFAULT_PASS', "C1sco123")
    queue = os.environ.get('RABBITMQ_QUEUE', "HackZurich16")
    port = int(os.environ.get('PORT', '5000'))
    print "##################################"
    print "# Starting Machine Simulator     #"
    print "# (c) 2016 Cisco                 #"
    print "# Server: %s #" % (host.ljust(22))
    print "# Port: %s #" % (os.environ.get('RABBITMQ_PORT', '5672').ljust(24))
    print "# Queue: %s #" % (queue.ljust(23))
    print "# User: %s #" % (user.ljust(24))
    print "# Password: %s #" % (passwd.ljust(20))
    print "# Delay: %s #" % (os.environ.get('DELAY', '2').ljust(23))
    print "# Port: %s #" % (os.environ.get('PORT', '5000').ljust(24))
    print "##################################"
    time.sleep(2)
    connection, channel = connect(host, rabbitport, user, passwd, queue, 10)
    m = Machine(5)

    app.run(host="0.0.0.0", port=port)
