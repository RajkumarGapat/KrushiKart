import React from 'react'
import { Container, Row, Col } from 'react-bootstrap'
const footer = () => {
  return (
    <>
      <footer>
        <Row>
          <div className="bg-dark text-light p-3">
            <Col className="text-center">
              <span>Copyright &copy; Krushikart info.</span>
            </Col>
          </div>
        </Row>
      </footer>
    </>
  )
}

export default footer
