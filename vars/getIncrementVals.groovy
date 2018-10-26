#! /usr/bin/groovy

 def getIncrementVals = {
	switch (params.INCREMENT_VERSION) {
              case 'MAJOR':
                     ++proplist.major
                     proplist.minor = 0
                     proplist.patch = 0
                     proplist.build = 1
                     break
              case 'MINOR':
                     ++proplist.minor
                     proplist.patch = 0
                     proplist.build = 1
                     break
              case 'PATCH':
                     ++proplist.patch
                     proplist.build = 1
                     break
        println proplist.major proplist.minor proplist.patch proplist.build
	  }
 }
 getIncrementVals () 

