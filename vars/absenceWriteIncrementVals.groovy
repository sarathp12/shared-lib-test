#! /usr/bin/groovy
def writeIncrementVals = {
	File x = new File('build-version.properties')
        x.createNewFile()
        x.write "# Property values when build-version.properties is not found\n"
        x << "major=0\n"
        x << "minor=0\n"
        x << "patch=0\n"
        x << "build=1\n"  
}
writeIncrementVals ()
