import PropTypes from 'prop-types'
import React from 'react'
import { Checkbox } from '../form'

function FieldCheckbox({ id, text, defaultChecked, onClick, disabled }) {
  return (
    <div className='control control-inline'>
      <label htmlFor={id}>{text}</label>
      <Checkbox
        id={id}
        value='true'
        defaultChecked={defaultChecked}
        disabled={disabled}
        handler={onClick}
      />
    </div>
  )
}

FieldCheckbox.defaultProps = {
  disabled: false
}

FieldCheckbox.propTypes = {
  id: PropTypes.string.isRequired,
  text: PropTypes.string.isRequired,
  defaultChecked: PropTypes.bool.isRequired,
  onClick: PropTypes.func.isRequired,
  disabled: PropTypes.bool,
}

export default FieldCheckbox
