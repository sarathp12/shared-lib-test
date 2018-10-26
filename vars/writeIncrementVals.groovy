#! /usr/bin/groovy
def writeIncrementVals = {
	 File x = new File('build-version.properties')
         x.write "# Altered property values when build-version.properties is found\n"
         x << "major=proplist.major\n"
         x << "minor=proplist.minor\n"
         x << "patch=proplist.patch\n"
         x << "build=proplist.build\n"  
 }
writeIncrementVals ()
