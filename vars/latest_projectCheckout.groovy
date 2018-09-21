import com.staples.cicd.pipeline.PipelineContext

def call(String stageName, PipelineContext context) {
	Map pipelineConfig = context.config.PipelineConfig
	String branchName=env.BRANCH_NAME

	// If this is an On-Demand Pipeline, the Branch value will be set by the user
	if ( params.PipelineBranch != null) {
		branchName = "${params.PipelineBranch}"
		if (branchName.startsWith("origin/")) {
           branchName = branchName.substring(7)
       }
	}

	def exists = fileExists '.git'
	
	if (exists) {
		sh("git clean -fd")
	}
	git([url: pipelineConfig['gitURl'], branch: 'COPS-419', credentialsId: 'final-ele-app-connect'])
	
        String commitHash = sh (returnStdout: true, script: "git rev-parse --short HEAD").trim()
	String buildId = "${env.BUILD_NUMBER}-${commitHash}"
	
	context.contextMap['BUILD_ID'] = buildId
	
	String commitAuthor = sh (returnStdout: true, script: "git show -s --format=\"%aN <%aE>\"").trim()
	String commitDate = sh (returnStdout: true, script: "git show -s --format=\"%cd>\"").trim()
	String commitMessage = sh (returnStdout: true, script: "git log -1 --pretty=%s").trim()
	String emailOutput = "\n ${stageName} - \n" \
					+ "\n SHA: ${commitHash}" \
					+ "\n Author: ${commitAuthor}" \
					+ "\n Date: ${commitDate}" \
					+ "\n Message: ${commitMessage} \n"

	context.appendToEmail(stageName, emailOutput)

	return true
}
